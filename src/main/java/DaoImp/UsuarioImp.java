package DaoImp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

@Repository
@Transactional
public class UsuarioImp implements IUsuario{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenT2LPII");

    @Override
    public void registrar(TblUsuariocl2 usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public TblUsuariocl2 buscarPorId(String usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :usuario", TblUsuariocl2.class)
                     .setParameter("usuario", usuario)
                     .getSingleResult();
        } finally {
            em.close();
        }
    }


    @Override
    public List<TblUsuariocl2> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM TblUsuariocl2 u", TblUsuariocl2.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(TblUsuariocl2 usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TblUsuariocl2 usuario = em.find(TblUsuariocl2.class, id);
            if (usuario != null) {
                em.getTransaction().begin();
                em.remove(usuario);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

	@Override
	public TblUsuariocl2 buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}