package com.niit.backend.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.CategoryDao;
import com.niit.backend.dto.Category;




@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertCategory(Category category) {
		try {
			getSession().persist(category);
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
			
		}
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Category getCategoryById(int categoryId) {
		return getSession().get(Category.class, categoryId);
		
	}

	public List<Category> listCategories() {
		@SuppressWarnings("unchecked")
		TypedQuery<Category> query=getSession().createQuery("from com.niit.backend.dto.Category");
		List<Category> list=query.getResultList();
		System.out.println("List of Categories : "+list);
		return list;
	}

}
