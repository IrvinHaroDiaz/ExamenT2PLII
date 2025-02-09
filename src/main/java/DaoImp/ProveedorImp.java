package DaoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Interfaces.IProveedor;
import model.TblProveedorcl2;



@Repository
@Transactional
public class ProveedorImp implements IProveedor{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenT2LPII");

    @Override
    public void registrar(TblProveedorcl2 proveedor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public TblProveedorcl2 buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(TblProveedorcl2.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<TblProveedorcl2> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM TblProveedorcl2 p", TblProveedorcl2.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(TblProveedorcl2 proveedor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(proveedor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TblProveedorcl2 proveedor = em.find(TblProveedorcl2.class, id);
            if (proveedor != null) {
                em.getTransaction().begin();
                em.remove(proveedor);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}