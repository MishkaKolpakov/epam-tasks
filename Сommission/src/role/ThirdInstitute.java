package role;

public class ThirdInstitute extends AbstractInstitute {
	@Override
	public void takeDocuments() {
		while (this.queue.peek().contains("Math")) {
			institute.add(queue.poll());
		}
	}
}
