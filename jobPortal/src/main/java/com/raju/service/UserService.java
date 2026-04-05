package com.raju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raju.model.ApplicantModel;
import com.raju.model.Credentials;
import com.raju.model.JobProfile;
import com.raju.model.feedbackModel;
import com.raju.model.jobModel;
import com.raju.repository.CredentialsRepo;
import com.raju.repository.PortalRepository;
import com.raju.repository.ProfilejobRepo;
import com.raju.repository.candidateRepo;
import com.raju.repository.feedbackRepo;

@Service
public class UserService {
	@Autowired
	private  candidateRepo cRep;
	@Autowired
	private  PortalRepository pRep;
	@Autowired
	private ProfilejobRepo pjRep;
	@Autowired
	private feedbackRepo fRep;
	@Autowired
	private CredentialsRepo credRepo;
	
	public void addCredentials(Credentials crd) {
		credRepo.save(crd);
	}
	
	
	public void addApplicant(ApplicantModel am) {
		cRep.save(am);
		
	}
	public void updateApplicant(ApplicantModel am) {
		cRep.save(am);
		
	}

	public ApplicantModel checkApplicant(String email,String password) {
		return cRep.checkApplicant(email, password);
		
	}

   public ApplicantModel getApplicant(int id) {
		
		return cRep.findById(id).orElseGet(()->new ApplicantModel());
		
	}
   public ApplicantModel getApplicant(String email) {
		
		return cRep.getByEmail(email);
		
	}


	public jobModel getJob(int id) {
		
		return pRep.findById(id).orElseGet(()->new jobModel());
		
	}
	
public List<jobModel> allJobs() 
{
		return pRep.findAll();
	}	
public List<jobModel> allJobsByLocationType(String jobtype,String joblocation) 
{
		return pRep.searchResultsByLocationtype(jobtype, joblocation);
	}	


public void profileJobMap(JobProfile jp) 
{
	 pjRep.save(jp);
}	
public JobProfile getProfileJobMap(int jobid,int profileid) 
{
	 return pjRep.getJobProfileMap(jobid, profileid);
}	
public List<Integer> getJobIds(int profileId){
	return pjRep.getjobProfilesIds(profileId);
	
}
public void deleteApplication(int jobid,int profileid){
	JobProfile jp=pjRep.getJobProfileMap(jobid, profileid);
	 pjRep.deleteById(jp.getId());
	
}
public void addfeedback(feedbackModel f) 
{
		fRep.save(f);
		
	}	

public Credentials getcredentials(String email) {
	 return credRepo.getcredentails(email);
}


public List<jobModel> searchCandidateJobs(String key){
	String Key=key.trim().toLowerCase();
	return pRep.searchResults(Key);
}


}
