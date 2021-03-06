package com.niit.backend.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dto.Category;
import com.niit.backend.dto.Product;



@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertProduct(Product product) {
		try {
			getSession().persist(product);
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
			
		}
	}

	public boolean updateProduct(Product product) {
		Session session=getSession();
		
		
		session.update(product);
		return true;
	}

	public boolean deleteProduct(int productId) {
		Session session=getSession();
		Product product=session.get(Product.class, productId);
		session.delete(product);
		return true;
	}

	public Product getProductById(int productId) {
		Product product=getSession().get(Product.class, productId);
		return product;
	}

	
	@Override
	public List<Product> getProducts() {
		
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.niit.backend.dto.Product");
		List<Product> list=query.getResultList();
		System.out.println("List of Products : "+list);
		return list;
		
	}

	@Override
	public List<Product> getProducts(String category) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.niit.backend.dto.Product where category.categoryName=:a");
		query.setParameter("a",category);
		List<Product> list=query.getResultList();
		System.out.println("List of Products : "+list);
		return list;
	}

	@Override
	public int getQuantity(int productId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.niit.backend.dto.Product where productId=:a");
		query.setParameter("a",productId);
		List<Product> list=query.getResultList();
		return list.get(0).getQuantity();
	}

	@Override
	public void updateQuantity(int productId, int newQuantity) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("update com.niit.backend.dto.Product set quantity=quantity-:b where productId=:a");
		query.setParameter("b",newQuantity);
		query.setParameter("a",productId);
		query.executeUpdate();
		
	}

}



















