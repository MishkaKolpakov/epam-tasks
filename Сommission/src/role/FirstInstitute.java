package role;

public class FirstInstitute extends AbstractInstitute {
	@Override
	public void takeDocuments() {
		while (this.queue.peek().contains("Biological")) {
			institute.add(queue.poll());
		}
	}
}
