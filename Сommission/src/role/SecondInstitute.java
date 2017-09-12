package role;

public class SecondInstitute extends AbstractInstitute {

	@Override
	public void takeDocuments() {
		int documentsAmount = (int) ((Math.random() * 5) + 1);
		for (int i = 1; i <= documentsAmount; i++) {
			institute.add(queue.poll());
		}
	}
}
