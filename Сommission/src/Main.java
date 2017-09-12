import java.util.LinkedList;
import java.util.Queue;

import model.entity.BiologyDocuments;
import model.entity.MathDocuments;
import model.service.DocumentsUtil;
import role.FirstInstitute;
import role.SecondInstitute;
import role.ThirdInstitute;

public class Main {
	public static void main(String[] args) {
		DocumentsUtil documentsUtil = new DocumentsUtil();
		BiologyDocuments biologyDocuments = new BiologyDocuments(documentsUtil.fillBiologyDocuments());
		MathDocuments mathDocuments = new MathDocuments(documentsUtil.fillMathDocuments());

		FirstInstitute firstInstitute = new FirstInstitute();
		SecondInstitute secondInstitute = new SecondInstitute();
		ThirdInstitute thirdInstitute = new ThirdInstitute();

		Thread firstThread = new Thread(firstInstitute);
		Thread secondThread = new Thread(secondInstitute);
		Thread thirdThread = new Thread(thirdInstitute);

		Queue<String> queue = new LinkedList<>();
		queue.add("Biological");
		queue.add("Biological");
		queue.add("Biological");
		queue.add("Math");
		queue.add("Math");
		queue.add("Biological");
		queue.add("Math");
		queue.add("Biological");
		queue.add("Math");
		queue.add("Math");

		
	}
}
