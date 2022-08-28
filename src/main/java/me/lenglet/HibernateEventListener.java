package me.lenglet;

import me.lenglet.entity.Aggregate;
import org.hibernate.action.spi.BeforeTransactionCompletionProcess;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventListener implements PostInsertEventListener {

    @Override
    public void onPostInsert(PostInsertEvent event) {
        if (event.getEntity() instanceof Aggregate aggregate) {
            Object objectToCreate;
            while ((objectToCreate = aggregate.pollObjectToCreate()) != null) {
                Object finalObjectToCreate = objectToCreate;
                event.getSession().getActionQueue().registerProcess(new BeforeTransactionCompletionProcess() {
                    @Override
                    public void doBeforeTransactionCompletion(SessionImplementor session) {
                        session.persist(finalObjectToCreate);
                        session.flush();
                    }
                });
            }
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }
}
