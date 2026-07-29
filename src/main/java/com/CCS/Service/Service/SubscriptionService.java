package com.CCS.Service.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Repo.SubscriptionRepo;
import com.CCS.Service.model.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	public List<Subscription> getAllSubscriptions(){
		 return subscriptionRepo.findAll();
	}
	
	public Optional<Subscription> getSubscription(Long id) {
		return subscriptionRepo.findById(id);
	}

	public Subscription newSubscription(Subscription subscription) {
		return  subscriptionRepo.save(subscription);
	}
	
	public Subscription UpdateSubscription(Subscription subscription) {
		return subscriptionRepo.save(subscription);
	}
	
	public void deletesubscription(Long id) {
		subscriptionRepo.deleteById(id);
	}
}