package mySpringBatchApp;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
 
@SpringBootApplication
@EnableScheduling
public class App 
{
    @Autowired
    JobLauncher jobLauncher;
     
    @Autowired
    Job job;
     
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }
 // methode definie avant d'integrer CRON et Task Scheduling 
//    public void run(String... args) throws Exception
//    {
//        JobParameters params = new JobParametersBuilder()
//                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                    .toJobParameters();
//        jobLauncher.run(job, params);
//    }
    
    // nouvelle methode avec CRON Scheduler 
    
    @Scheduled(cron = "0/30 21-27 * ? * *")
    public void perform() throws Exception
    {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }

	
	
    
}