package com.niit.backend.daoimpl;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.SupplierDao;
import com.niit.backend.dto.Supplier;


@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean insertSupp(Supplier supplier) {
		System.out.println("I m Here...");
		try {
			getSession().persist(supplier);
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
			
		}
		
	}

	public Supplier getSupplierById(int supplierId){
		return getSession().get(Supplier.class,supplierId);
	}

	public boolean updateSupp(Supplier supplier) {
		try {
			
			//Supplier obj=getSession().get(Supplier.class,supplier.getSupplierId());
			//System.out.println("obj : "+obj);
			getSession().update(supplier);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSupp(int supplierId) {
		Supplier obj=(Supplier)getSession().get(Supplier.class, supplierId);
		if(obj!=null){
			getSession().delete(obj);
			return true;
		}
		else {
			return false;
		}
	}

	public List<Supplier> listSuppliers() {
		@SuppressWarnings("unchecked")
		TypedQuery<Supplier> query=getSession().createQuery("from com.niit.backend.dto.Supplier");
		List<Supplier> list=query.getResultList();
		System.out.println("List of Suppliers : "+list);
		return list;	}

}
