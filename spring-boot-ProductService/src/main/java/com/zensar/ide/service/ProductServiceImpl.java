package com.zensar.ide.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Direction;
import com.zensar.ide.dto.ProductDto;
import com.zensar.ide.entity.Product;
import com.zensar.ide.exceptions.NoSuchProductExistsException;
import com.zensar.ide.exceptions.ProductAlreadyExistsException;
import com.zensar.ide.repository.ProductRepository;

@Service 
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto getProduct(int productId) {
		Product product = productRepository.findById(productId).orElse(null);
		// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
		if (product == null) {
			throw new NoSuchProductExistsException("Product doesn't exists");
		}
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getProducts(int pageNumber, int pageSize, String sortBy, Direction dir) {
		// List<Product> findAll = productRepository.findAll();
		// Page<Product> findAll =
		// productRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"productName")));
			if(productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(dir, sortBy))).isEmpty())
				// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
				throw new NoSuchProductExistsException("product doesnt exists");
			Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(dir, sortBy)));
			List<Product> content = findAll.getContent();
			List<ProductDto> dto = new ArrayList<ProductDto>();
			for (Product product : content)
				dto.add(modelMapper.map(product, ProductDto.class));
			return dto;
		
	}

	@Override
	public ProductDto insert(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		// if an product already exists it throws an exception and call ProductAlreadyExists Exception method
		Product getProduct = productRepository.findById(product.getProductId()).orElse(null);
		if (getProduct == null) {
			productRepository.save(modelMapper.map(productDto, Product.class));
			return productDto;
		} else {
			throw new ProductAlreadyExistsException("Product already exists");
		}

	}

	@Override
	public void update(int productId, ProductDto productDto) {
		Product getProduct = productRepository.findById(productId).orElse(null);
		// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
		if (getProduct == null)
			throw new NoSuchProductExistsException("Product doesn't exists to update it");
		productRepository.save(modelMapper.map(productDto, Product.class));
	}

	@Override
	public void delete(int productId) {
		Product getProduct = productRepository.findById(productId).orElse(null);
		// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
		if (getProduct == null)
			throw new NoSuchProductExistsException("Product doesn't exists to delete it");
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductDto> getByProductName(String productName) {
		//List<Product> findbyProductName = productRepository.findByProductName(productName);
			if(productRepository.byName(productName).isEmpty())
				// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
				throw new NoSuchProductExistsException("product doesnt exists");
			List<Product> findbyProductName = productRepository.byName(productName);
			List<ProductDto> productDtos = new ArrayList<ProductDto>();
			for (Product product : findbyProductName)
				productDtos.add(modelMapper.map(product, ProductDto.class));
			return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameAndProductPrice(String productName, int productPrice) {
			if(productRepository.findByProductNameAndProductPrice(productName, productPrice).isEmpty()) 
				// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
				throw new NoSuchProductExistsException("product doesnt exists");
			List<Product> products = productRepository.findByProductNameAndProductPrice(productName, productPrice);
			List<ProductDto> productDtos = new ArrayList<ProductDto>();
			for (Product product : products)
			productDtos.add(modelMapper.map(product, ProductDto.class));
			return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameOrProductPrice(String productName, int productPrice) {
		// List<Product> products =
		// productRepository.findByProductNameOrProductPrice(productName, productPrice);
			if(productRepository.byNameOrPrice(productName, productPrice).isEmpty())
				// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
				throw new NoSuchProductExistsException("product doesnt exists");
			List<Product> products = productRepository.byNameOrPrice(productName, productPrice);
			List<ProductDto> productDtos = new ArrayList<ProductDto>();
			for (Product product : products)
				productDtos.add(modelMapper.map(product, ProductDto.class));
			return productDtos;
	}

	@Override
	public List<ProductDto> getByProductNameOrderByProductQuantity(String productName) {
		if(productRepository.findByProductNameOrderByProductQuantity(productName).isEmpty())
			// if there is no such product exists then it throws an error and calls NoSuchProductExistsException method
			throw new NoSuchProductExistsException("product doesnt exists");
		List<Product> findbyProductName = productRepository.findByProductNameOrderByProductQuantity(productName);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : findbyProductName)
			productDtos.add(modelMapper.map(product, ProductDto.class));
		return productDtos;
	}

}
