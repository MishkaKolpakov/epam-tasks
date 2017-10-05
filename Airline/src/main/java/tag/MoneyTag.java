package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import config.MessageManager;

public class MoneyTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private Integer amountInCents;

	public void setAmountInCents(Integer amountInCents) {
		this.amountInCents = amountInCents;
	}

	@Override
	public int doStartTag() throws JspException {
		
		String cents = String.valueOf(amountInCents);
		String formatCash = cents.substring(0, cents.length() - 2);
		String formatCents = cents.substring(cents.length() - 2);	

		try {
			pageContext.getOut().write(formatCash + "," + formatCents + MessageManager.getProperty("currency"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
