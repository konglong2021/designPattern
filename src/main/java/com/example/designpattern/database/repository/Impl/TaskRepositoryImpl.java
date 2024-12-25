package com.example.designpattern.database.repository.Impl;

import com.example.designpattern.database.entity.QTask;
import com.example.designpattern.database.entity.Task;
import com.example.designpattern.database.repository.TaskRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    private EntityManager em;
    public static final Integer STATUS_COMPLETED = 1 ;
    private static final  QTask task = QTask.task;
//    @Override
//    public List<Task> getTasksByEmployeeId(Long employeeId) {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        return queryFactory.selectFrom(task)
//               .where(task.employee.id.eq(employeeId))
//               .fetch();
//    }
//
//    @Override
//    public List<Task> getTasksByStatus(Integer status) {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        return queryFactory.selectFrom(task)
//               .where(task.status.eq(status))
//               .fetch();
//    }

    @Override
    public void completeTask(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        queryFactory.update(task)
               .set(task.isCompleted, true)
               .where(task.id.eq(id))
               .execute();
    }

    @Override
    public void reopenTask(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        queryFactory.update(task)
               .set(task.isCompleted, false)
               .where(task.id.eq(id))
               .execute();
    }

//    @Override
//    public List<Task> getAllTasks() {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        return queryFactory.selectFrom(task)
//               .fetch();
//    }
//
//    @Override
//    public List<Task> getIncompleteTasks() {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        return queryFactory.selectFrom(task)
//               .where(task.isCompleted.eq(false))
//               .fetch();
//    }
//
//    @Override
//    public List<Task> getCompletedTasks() {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        return queryFactory.selectFrom(task)
//               .where(task.isCompleted.eq(true))
//               .fetch();
//    }
}
