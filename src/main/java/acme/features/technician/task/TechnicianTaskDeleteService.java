
package acme.features.technician.task;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.services.AbstractGuiService;
import acme.client.services.GuiService;
import acme.entities.task.Involves;
import acme.entities.task.Task;
import acme.realms.employee.Technician;

@GuiService
public class TechnicianTaskDeleteService extends AbstractGuiService<Technician, Task> {

	@Autowired
	private TechnicianTaskRepository repository;


	@Override
	public void authorise() {
		boolean status;
		int masterId;
		Task task;
		Technician technician;

		masterId = super.getRequest().getData("id", int.class);
		task = this.repository.findTaskById(masterId);
		technician = task == null ? null : task.getTechnician();
		status = task != null && task.isDraftMode() && super.getRequest().getPrincipal().hasRealm(technician);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Task task;
		int id;

		id = super.getRequest().getData("id", int.class);
		task = this.repository.findTaskById(id);

		super.getBuffer().addData(task);
	}

	@Override
	public void bind(final Task task) {

		super.bindObject(task, "type", "description", "priority", "estimatedDuration");
	}

	@Override
	public void validate(final Task task) {
		;
	}

	@Override
	public void perform(final Task task) {
		Collection<Involves> involves;

		involves = this.repository.findInvolvesByTaskId(task.getId());
		this.repository.deleteAll(involves);
		this.repository.delete(task);
	}

	@Override
	public void unbind(final Task task) {
		//		Dataset dataset;
		//		SelectChoices choices;

		//		choices = SelectChoices.from(TaskType.class, task.getType());

		//		dataset = super.unbindObject(task, "type", "description", "priority", "estimatedDuration", "draftMode");
		//		dataset.put("types", choices);

		//		super.getResponse().addData(dataset);
	}
}
