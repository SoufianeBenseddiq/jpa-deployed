package ma.ensa.jsftp1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import ma.ensa.jsftp1.entity.Student;

import java.util.List;

public class StudentDao {
    EntityManager em = DatabasePersistence.getEntityManager();
    public void create(Student student){
        try{
            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            em.persist(student);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    public void update(Student student){
        try{
            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            em.merge(student);
            em.getTransaction().commit();
            
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
    public void delete(Student student){
        try{
            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            em.remove(em.contains(student) ? student : em.merge(student));
            em.getTransaction().commit();
            
        }catch (Exception e){
            em.getTransaction().rollback();
            
        }
    }

    // pas besoin de transaction en select
    public List<Student> findAll(){
        try{
//            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            Query query = em.createQuery("SELECT student from Student student"); // jpql
            List<Student> students = query.getResultList();
//            em.getTransaction().commit();
            
            return students;
        }catch (Exception e){
//            em.getTransaction().rollback();
            return null;
        }
    }

    public List<Student> findAllFromTo(){
        
        try{
//            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            Query query = em.createQuery("SELECT student from Student student ORDER BY student.name"); // jpql
            query.setFirstResult(0);
            query.setMaxResults(3);
            List<Student> students = (List<Student>) query.getResultList();
//            em.getTransaction().commit();
            
            return students;
        }catch (Exception e){
//            em.getTransaction().rollback();
            return null;
        }
    }
    public List<Student> findAllFromTo(int offset, int size){
        
        try{
//            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            Query query = em.createQuery("SELECT student from Student student ORDER BY student.name"); // jpql
            query.setFirstResult(offset);
            query.setMaxResults(size);
            List<Student> students = (List<Student>) query.getResultList();
//            em.getTransaction().commit();
            
            return students;
        }catch (Exception e){
//            em.getTransaction().rollback();
            return null;
        }
    }

    public Student findById(long id){
        
        Student student = null;
        try{
//            em.getTransaction().begin();//without transaction, we persiste only in memory, initial phase, if smth falls we rollback
            student = em.find(Student.class, id);
//            em.getTransaction().commit();
            
        }catch (Exception e){
//            em.getTransaction().rollback();
        }
        return student;
    }
}
