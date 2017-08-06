package akul.schedule.application.service;


import java.util.List;



import org.hibernate.Query;

import akul.schedule.application.dto.ScheduleModal;
import akul.schedule.application.exception.DataNotFound;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class scheduleService {
	
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	
	/*public List<ScheduleModal> testservice(){
		
		ScheduleModal sch=new ScheduleModal();
//		sch.setTask("Task1");
	//	sch.getListOfTasks().add("schedule1");
//		sch.getListOfTasks().add("schedule2");
	//	sch.getListOfTasks().add("schedule3");
		
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
//		session.save(sch);
	//	session.getTransaction().commit();
		session.close();

		sch=null;

		session=sessionfactory.openSession();
		session.beginTransaction();
		//sch=(ScheduleModal) session.get(ScheduleModal.class, "Task1");
		Query query = session.createQuery("from ScheduleModal");
		List results = (List<ScheduleModal>)query.list();
		
		return results;
		//String[] a1=sch.getListOfTasks();
		//for(int i=0;i<a1.length;i++)
			//System.out.println(a1[i]);
		
		
	}*/
		public List<ScheduleModal> getallschdserv(){
			
			ScheduleModal sch=new ScheduleModal();
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from ScheduleModal");
			List results = (List<ScheduleModal>)query.list();	
			return results;
			
		}
	
		public ScheduleModal getschdserv(String taskname){
			
			ScheduleModal sch=new ScheduleModal();
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			sch=(ScheduleModal) session.get(ScheduleModal.class, taskname);
			if(sch==null){
				throw new DataNotFound(taskname+" not found");
			}
			return sch;
			
			
		}
		
		public void dbsaveserv(ScheduleModal ob){
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.save(ob);
			session.getTransaction().commit();
			session.close();
		}
		
		public void updateschdserv(ScheduleModal ob){			
			String tasktoupdate=ob.getTask();
			ScheduleModal obtoupdate=getschdserv(tasktoupdate);
			obtoupdate.setListOfTasks(ob.getListOfTasks());
			
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.update(obtoupdate);
			session.getTransaction().commit();
			session.close();
		}
		
		public void deleteschdserv(String taskname){
			
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			ScheduleModal sch=(ScheduleModal) session.get(ScheduleModal.class, taskname);
			session.delete(sch);
			session.getTransaction().commit();
			session.close();
		}
}
