package home.nust.dc.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Duplicatechecking entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "duplicatechecking", catalog = "zack")
public class Duplicatechecking implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String major;
	private String class_;
	private String papertitle;
	private String teacher;
	private String reasonofchecking;
	private Date timeofdelivery;

	// Constructors

	/** default constructor */
	public Duplicatechecking() {
	}

	/** minimal constructor */
	public Duplicatechecking(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Duplicatechecking(Long id, String name, String major, String class_,
			String papertitle, String teacher, String reasonofchecking,
			Date timeofdelivery) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.class_ = class_;
		this.papertitle = papertitle;
		this.teacher = teacher;
		this.reasonofchecking = reasonofchecking;
		this.timeofdelivery = timeofdelivery;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "major", length = 40)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "class", length = 40)
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	@Column(name = "papertitle", length = 100)
	public String getPapertitle() {
		return this.papertitle;
	}

	public void setPapertitle(String papertitle) {
		this.papertitle = papertitle;
	}

	@Column(name = "teacher", length = 20)
	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Column(name = "reasonofchecking", length = 40)
	public String getReasonofchecking() {
		return this.reasonofchecking;
	}

	public void setReasonofchecking(String reasonofchecking) {
		this.reasonofchecking = reasonofchecking;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "timeofdelivery", length = 10)
	public Date getTimeofdelivery() {
		return this.timeofdelivery;
	}

	public void setTimeofdelivery(Date timeofdelivery) {
		this.timeofdelivery = timeofdelivery;
	}

	@Override
	public String toString() {
		return "Duplicatechecking [id=" + id + ", name=" + name + ", major="
				+ major + ", class_=" + class_ + ", papertitle=" + papertitle
				+ ", teacher=" + teacher + ", reasonofchecking="
				+ reasonofchecking + ", timeofdelivery=" + timeofdelivery + "]";
	}

}