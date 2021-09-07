package br.com.estudo.springsecurity.exemplo.util;

import br.com.estudo.springsecurity.exemplo.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@SuppressWarnings("ALL")
public interface GenericService<T extends Convertible<D>, D, K> {

	JpaRepository<T, K> getRepository();

	default D findById(K id) {
		Optional<T> result = getRepository().findById(id);
		return result.isPresent() ? result.get().convert() : null;
	}

	default D create(T entity) {
		T create = getRepository().save(entity);
		return create.convert();
	}

	default D update(K id, T entity) {
		T find = getRepository().findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(getGenericName(), "id", id));
		return getRepository().save(entity).convert();

	}

	default void remove (K id) {
		T find = getRepository().findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(getGenericName(), "id", id));

		getRepository().delete(find);
	}

	default Page<D> findAll(Pageable pageable) {
		return getRepository().findAll(pageable).map(T::convert);
	}


	default String getGenericName()	{
		return ((Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
	}

}
