package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TodoRepositoryCustomImpl implements TodoRepositoryCustom {

    private final JPAQueryFactory qf;

    @Autowired
    public TodoRepositoryCustomImpl(JPAQueryFactory qf) {
        this.qf = qf;
    }

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {
        QTodo todo = QTodo.todo;
        QUser user = QUser.user;

        Todo result = qf.selectFrom(todo)
                .leftJoin(user)
                .where(todo.id.eq(todoId))
                .fetchOne();

        return Optional.ofNullable(result);
    }
}
