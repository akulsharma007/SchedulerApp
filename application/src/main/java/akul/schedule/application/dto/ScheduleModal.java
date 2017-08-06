package akul.schedule.application.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@XmlRootElement
public class ScheduleModal {
	@Id
	private String task;
	@ElementCollection
	@GenericGenerator(name="increment", strategy = "increment") 
	@CollectionId(columns={ @Column(name="schedId")},generator="increment",type=@Type(type="long") )
	private List<String> listOfTasks=new ArrayList<String>();
	
	@Transient
	private String linkUri;
	
	
	public String getLinkUri() {
		return linkUri;
	}
	public void setLinkUri(String linkUri) {
		this.linkUri = linkUri;
	}
	public List<String> getListOfTasks() {
		return listOfTasks;
	}
	public void setListOfTasks(List<String> listOfTasks) {
		this.listOfTasks = listOfTasks;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}	
}
