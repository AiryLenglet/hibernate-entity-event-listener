package me.lenglet;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@Configuration
public class HibernateListenerConfig {

    private final EntityManagerFactory entityManagerFactory;

    public HibernateListenerConfig(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @PostConstruct
    public void init() {
        final var sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        final var registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        final var listener = new HibernateEventListener();
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(listener);
    }
}
