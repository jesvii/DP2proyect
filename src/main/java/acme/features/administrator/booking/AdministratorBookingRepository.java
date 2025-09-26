
package acme.features.administrator.booking;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.booking.Booking;

@Repository
public interface AdministratorBookingRepository extends AbstractRepository {

	@Query("select b from Booking b where b.draftMode=false")
	public Collection<Booking> findAllPublishedBookings();

	@Query("select b from Booking b where b.id=:id")
	public Booking findBookingById(int id);
}
