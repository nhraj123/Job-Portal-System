package com.raju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raju.model.ApplicantModel;
import com.raju.model.Credentials;
import com.raju.model.RecruiterModel;
import com.raju.model.feedbackModel;
import com.raju.model.jobModel;
import com.raju.repository.CredentialsRepo;
import com.raju.repository.PortalRepository;
import com.raju.repository.ProfilejobRepo;
import com.raju.repository.RecruiterRepo;
import com.raju.repository.candidateRepo;
import com.raju.repository.feedbackRepo;

@Service
public class AdminService {
	
	@Autowired
	private  PortalRepository repo;
	
	@Autowired
	private ProfilejobRepo pjRepo;
	
	@Autowired
	private  candidateRepo Crepo;
	
	@Autowired
	private feedbackRepo fRepo;
	
	@Autowired
	private RecruiterRepo recRepo;
	
	@Autowired
	private CredentialsRepo credRepo;
	
	public void addJob(jobModel j) {
		repo.save(j);
		
		
	}
	public void deleteJob(int id) {
		repo.deleteById(id);
	}
	public void updateJob(jobModel j) {
		jobModel uj=repo.findById(j.getId()).get();
		uj.setCode(j.getCode());
		uj.setCompany(j.getCompany());
		uj.setTitle(j.getTitle());
		uj.setDescription(j.getDescription());
		uj.setEmployementType(j.getEmployementType());
		uj.setExperienceLevel(j.getExperienceLevel());
		uj.setUrl(j.getUrl());
		uj.setPackage(j.getPackage());
		uj.setWorkType(j.getWorkType());
		uj.setLocation(j.getLocation());
		uj.setRequirements(j.getRequirements());
	repo.save(uj);
	}
	public jobModel getJob(int id) {
		
		return repo.findById(id).orElseGet(()->new jobModel());
		
	}
	
public List<jobModel> allJobs() 
{
		return repo.findAll();
	}	

public List<jobModel> searchJobs(String key){
	String Key=key.trim().toLowerCase();
	return repo.searchResults(Key);
}

public List<Integer> allApplicantsIds(int jobid) 
{
		return pjRepo.getAllApplicants(jobid);
	}	
public ApplicantModel ApplicantsinfoById(int profileid) 
{
		return Crepo.findById(profileid).get();
	}	

public List<feedbackModel> allFeedbacks() 
{
		return fRepo.findAll();
	}	

public void deleteFeedback(int id) {
	fRepo.deleteById(id);
}

public void addRecruiter(RecruiterModel rm) {
	Credentials cred=new Credentials();
	cred.setEmail(rm.getEmail());
	cred.setRole("Admin");
	cred.setPassword(rm.getPassword());
		credRepo.save(cred);
	recRepo.save(rm);
}
public RecruiterModel getRecruiter(String email) {
	return recRepo.getrecruiter(email);
}

public Credentials getCredentials(String email) {
	return credRepo.getcredentails(email);
}
//public List<ApplicantModel> searchAllApplicants(String key) 
//{
//		return Crepo.searchApplicants(key);
//	}	

//public List<ApplicantModel> searchAllApplicantsByscore(double key) 
//{
//		return Crepo.searchApplicantsByScore(key);
//	}	
}
