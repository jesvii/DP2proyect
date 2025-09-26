
package acme.features.technician.involvedIn;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.controllers.AbstractGuiController;
import acme.client.controllers.GuiController;
import acme.entities.task.Involves;
import acme.realms.employee.Technician;

@GuiController
public class TechnicianInvolvesController extends AbstractGuiController<Technician, Involves> {

	@Autowired
	private TechnicianInvolvesListService	listService;

	@Autowired
	private TechnicianInvolvesShowService	showService;

	@Autowired
	private TechnicianInvolvesCreateService	createService;

	@Autowired
	private TechnicianInvolvesDeleteService	deleteService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("delete", this.deleteService);
	}
}
