package com.test.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.dialect.Dialect;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.jdbc.dialect.internal.StandardDialectResolver;
import org.hibernate.service.jdbc.dialect.spi.DialectResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.DaoInterface;
import com.test.entity.RegistrationEntity;

import oracle.net.aso.s;

@Repository
@Transactional
public class DaoImplClass implements DaoInterface
{
/*	static Logger logger = Logger.getLogger(DaoImplClass.class.getName());

	@Autowired SessionFactory sessionFactory;
*/	

	
}