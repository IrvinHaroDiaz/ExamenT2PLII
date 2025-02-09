package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

@Repository
@Transactional
public class UsuarioImp implements IUsuario{

    @PersistenceContext
    private EntityManager entityManager;
    
	@Override
	public void registrar(TblUsuariocl2 usuario) {
		entityManager.persist(usuario);
    }

	@Override
	public TblUsuariocl2 buscarPorId(int id) {
		return entityManager.find(TblUsuariocl2.class, id);
    }

	@Override
	public List<TblUsuariocl2> listarTodos() {
		TypedQuery<TblUsuariocl2> query = entityManager.createQuery("SELECT u FROM TblUsuariocl2 u", TblUsuariocl2.class);
        return query.getResultList();
    }

	@Override
	public void actualizar(TblUsuariocl2 usuario) {
		entityManager.merge(usuario);
    }

	@Override
	public void eliminar(int id) {
		TblUsuariocl2 usuario = buscarPorId(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
	}

	public boolean validarUsuario(String usuario, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
