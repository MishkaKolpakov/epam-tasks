package model;

import dao.individual.IndividualDAO;
import dao.property.PropertyDAO;
import model.entity.derivative.Derivative;
import model.service.DerivativeUtil;

public class Model {
	
	private Derivative derivative;
	private DerivativeUtil derivativeUtil;

	public Model() {
		derivative = new Derivative(new IndividualDAO(), new PropertyDAO());
		derivativeUtil = new DerivativeUtil(derivative);
	}

	public Derivative getDerivative() {
		return derivative;
	}

	public void setDerivative(Derivative derivative) {
		this.derivative = derivative;
	}
	
	public DerivativeUtil getDerivativeUtil() {
		return derivativeUtil;
	}

	public void setDerivativeUtil(DerivativeUtil derivativeUtil) {
		this.derivativeUtil = derivativeUtil;
	}

}
