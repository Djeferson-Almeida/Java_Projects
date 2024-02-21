package services;

import java.security.InvalidParameterException;

public class BrazilInterestService implements InterestService {

	private Double interestRate;

	public BrazilInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}

	

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public double getInterestRate() {
		return interestRate;
	}
	
	
}
