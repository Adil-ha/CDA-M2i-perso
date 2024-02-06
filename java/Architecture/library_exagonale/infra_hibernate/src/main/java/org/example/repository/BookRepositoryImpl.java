package org.example.repository;

import org.example.Util.HibernateSession;
import org.example.entity.Book;
import org.example.entity.BookEntity;
import org.example.spi.port.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private BookEntityRepository bookEntityRepository;
    private final SessionFactory sessionFactory;

    public BookRepositoryImpl() {
        this.sessionFactory = HibernateSession.getSessionFactory();
        bookEntityRepository = new BookEntityRepository();
    }

    @Override
    public boolean create(Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            BookEntity bookEntity = BookEntity.builder()
                    .author(book.getAuthor())
                    .title(book.getTitle())
                    .build();
            session.save(bookEntity);
            book.setId(bookEntity.getId());
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public boolean delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public Book findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> query = session.createQuery("from Book", Book.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sessionFactory.close();
        }
    }
}

