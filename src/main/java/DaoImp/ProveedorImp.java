package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Interfaces.IProveedor;
import model.TblProveedorcl2;

@Repository
@Transactional
public class ProveedorImp implements IProveedor{

	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public void registrar(TblProveedorcl2 proveedor) {
		entityManager.persist(proveedor);
    }

	@Override
	public TblProveedorcl2 buscarPorId(int id) {
		return entityManager.find(TblProveedorcl2.class, id);
    }

	@Override
	public List<TblProveedorcl2> listarTodos() {
		TypedQuery<TblProveedorcl2> query = entityManager.createQuery("SELECT p FROM TblProveedorcl2 p", TblProveedorcl2.class);
        return query.getResultList();
    }

	@Override
	public void actualizar(TblProveedorcl2 proveedor) {
		entityManager.merge(proveedor);
    }

	@Override
	public void eliminar(int id) {
		TblProveedorcl2 proveedor = buscarPorId(id);
        if (proveedor != null) {
            entityManager.remove(proveedor);
        }
		
	}

}
