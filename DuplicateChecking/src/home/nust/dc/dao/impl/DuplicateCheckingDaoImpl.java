package home.nust.dc.dao.impl;

import home.nust.dc.dao.DuplicateCheckingDao;
import home.nust.dc.entity.Duplicatechecking;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Duplicatechecking entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see home.nust.dc.entity.Duplicatechecking
 * @author MyEclipse Persistence Tools
 */

@Repository("duplicateCheckingDao")
@Transactional
public class DuplicateCheckingDaoImpl implements DuplicateCheckingDao {
	private static final Logger log = LoggerFactory.getLogger(DuplicateCheckingDaoImpl.class);
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Duplicatechecking transientInstance) {
		log.debug("saving Duplicatechecking instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Duplicatechecking persistentInstance) {
		log.debug("deleting Duplicatechecking instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Duplicatechecking findById(java.lang.Long id) {
		
		log.debug("getting Duplicatechecking instance with id: " + id);
		try {
			Duplicatechecking instance = (Duplicatechecking) getCurrentSession()
					.get("home.nust.dc.entity.Duplicatechecking", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Duplicatechecking> findByExample(Duplicatechecking instance) {
		log.debug("finding Duplicatechecking instance by example");
		try {
			List<Duplicatechecking> results = (List<Duplicatechecking>) getCurrentSession()
					.createCriteria("home.nust.dc.entity.Duplicatechecking")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Duplicatechecking instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Duplicatechecking as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List<Duplicatechecking> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	@Override
	public List<Duplicatechecking> findByMajor(Object major) {
		return findByProperty(MAJOR, major);
	}

	@Override
	public List<Duplicatechecking> findByClass_(Object class_) {
		return findByProperty(CLASS_, class_);
	}

	@Override
	public List<Duplicatechecking> findByPapertitle(Object papertitle) {
		return findByProperty(PAPERTITLE, papertitle);
	}

	@Override
	public List<Duplicatechecking> findByTeacher(Object teacher) {
		return findByProperty(TEACHER, teacher);
	}

	@Override
	public List<Duplicatechecking> findByReasonofchecking(
			Object reasonofchecking) {
		return findByProperty(REASONOFCHECKING, reasonofchecking);
	}

	@Override
	public List findAll() {
		log.debug("finding all Duplicatechecking instances");
		try {
			String queryString = "from Duplicatechecking";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public Duplicatechecking merge(Duplicatechecking detachedInstance) {
		log.debug("merging Duplicatechecking instance");
		try {
			Duplicatechecking result = (Duplicatechecking) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Duplicatechecking instance) {
		log.debug("attaching dirty Duplicatechecking instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Duplicatechecking instance) {
		log.debug("attaching clean Duplicatechecking instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DuplicateCheckingDao getFromApplicationContext(
			ApplicationContext ctx) {
		return (DuplicateCheckingDao) ctx.getBean("duplicateCheckingDao");
	}

	@Override
	public int findCount() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Duplicatechecking");
		Long count = (Long) query.uniqueResult();
		return count.intValue();
//		Criteria criteria = session.createCriteria(Duplicatechecking.class);
//		criteria.setProjection(Projections.rowCount());
//		Long count = (Long)criteria.uniqueResult();
	}

	@Override
	public List<Duplicatechecking> findByCurrentPage(int currentPageIndex,
			int everyPageRecordCount) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Duplicatechecking.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(everyPageRecordCount);
		@SuppressWarnings("unchecked")
		List<Duplicatechecking> dcList = criteria.list();
		return dcList;
	}
	
	
}