package model.entity.employee;

public enum Position {

	WORKER {
		{
			this.salaryRate = 3500L;
		}
	},
	MANAGER {
		{
			this.salaryRate = 5000L;
		}

	},
	OTHER {
		{
			this.salaryRate = 3000L;
		}

	},
	DIRECTOR {
		{
			this.salaryRate = 5000L;
		}
	},
	SECRETARY {
		{
			this.salaryRate = 2000L;
		}
	},
	LAWYER {
		{
			this.salaryRate = 4000L;
		}
	};

	Long salaryRate;

	public Long getSalaryRate() {
		return salaryRate;
	}

}
