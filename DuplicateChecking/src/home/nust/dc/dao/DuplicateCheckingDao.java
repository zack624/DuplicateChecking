package home.nust.dc.dao;

import home.nust.dc.entity.Duplicatechecking;

import java.util.List;

import org.hibernate.SessionFactory;

public interface DuplicateCheckingDao {

	// property constants
	public static final String NAME = "name";
	public static final String MAJOR = "major";
	public static final String CLASS_ = "class_";
	public static final String PAPERTITLE = "papertitle";
	public static final String TEACHER = "teacher";
	public static final String REASONOFCHECKING = "reasonofchecking";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Duplicatechecking transientInstance);

	public abstract void delete(Duplicatechecking persistentInstance);

	public abstract Duplicatechecking findById(java.lang.Long id);

	public abstract List<Duplicatechecking> findByExample(
			Duplicatechecking instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Duplicatechecking> findByName(Object name);

	public abstract List<Duplicatechecking> findByMajor(Object major);

	public abstract List<Duplicatechecking> findByClass_(Object class_);

	public abstract List<Duplicatechecking> findByPapertitle(Object papertitle);

	public abstract List<Duplicatechecking> findByTeacher(Object teacher);

	public abstract List<Duplicatechecking> findByReasonofchecking(
			Object reasonofchecking);

	public abstract List findAll();

	public abstract Duplicatechecking merge(Duplicatechecking detachedInstance);

	public abstract void attachDirty(Duplicatechecking instance);

	public abstract void attachClean(Duplicatechecking instance);
	
	public int findCount();
	
	/**
	 * 查找当前页的所有记录
	 * @param currentPage
	 * @param everyPageRecordCount
	 * @return
	 */
	public List<Duplicatechecking> findByCurrentPage(int currentPageIndex , int everyPageRecordCount);

	public List findStuCountOfMajor();
}