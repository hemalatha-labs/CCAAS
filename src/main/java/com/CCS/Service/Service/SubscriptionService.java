package com.CCS.Service.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CCS.Service.Mapper.SubscriptionMapper;
import com.CCS.Service.Repo.SubscriptionRepo;
import com.CCS.Service.RequestDTO.SubscriptionRequestDTO;
import com.CCS.Service.ResponseDTO.SubscriptionResponseDTO;
import com.CCS.Service.Validation.SubscriptionValidator;
import com.CCS.Service.globalException.ResourceNotFoundException;
import com.CCS.Service.model.Subscription;
import com.CCS.Service.Enumuration.SubscriptionPlan;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private SubscriptionMapper subscriptionMapper;

    @Autowired
    private SubscriptionValidator subscriptionValidator;


    // GET ALL SUBSCRIPTIONS
    public List<SubscriptionResponseDTO> getAllSubscriptions() {

        return subscriptionRepo.findAll()
                .stream()
                .map(subscriptionMapper::toResponseDTO)
                .toList();
    }


    // GET SUBSCRIPTION BY ID
    public SubscriptionResponseDTO getSubscription(Long id) {

        Subscription subscription =
                subscriptionRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Subscription not found with id: " + id
                        ));

        return subscriptionMapper.toResponseDTO(subscription);
    }


    // CREATE SUBSCRIPTION
 /*   public SubscriptionResponseDTO newSubscription(
            SubscriptionRequestDTO dto) {

        subscriptionValidator.validate(dto);

        Subscription subscription =
                subscriptionMapper.toEntity(dto);

        Subscription savedSubscription =
                subscriptionRepo.save(subscription);

        return subscriptionMapper.toResponseDTO(
                savedSubscription
        );
    }
*/
 // CREATE SUBSCRIPTION
    public SubscriptionResponseDTO newSubscription(
            SubscriptionRequestDTO dto) {

        // 1. Validate
        subscriptionValidator.validate(dto);

        // 2. DTO -> Entity
        Subscription subscription =
                subscriptionMapper.toEntity(dto);

        // 3. Get selected plan
        SubscriptionPlan plan =
                subscription.getPlanName();

        // 4. Automatically generate price
        subscription.setPrice(
                (double) plan.getPrice()
        );

        // 5. Automatically generate expiry date
        subscription.setExpiryDate(
                LocalDate.now()
                        .plusDays(plan.getValidityDays())
        );

        // 6. Save
        Subscription savedSubscription =
                subscriptionRepo.save(subscription);

        // 7. Entity -> Response DTO
        return subscriptionMapper.toResponseDTO(
                savedSubscription
        );
    }
    

    // UPDATE SUBSCRIPTION
    public SubscriptionResponseDTO updateSubscription(
            Long id,
            SubscriptionRequestDTO dto) {

        subscriptionValidator.validate(dto);

        Subscription existingSubscription =
                subscriptionRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Subscription not found with id: " + id
                        ));

        existingSubscription.setPlanName(
                dto.getPlanName()
        );

        // Automatically update price
        existingSubscription.setPrice(
                (double) dto.getPlanName().getPrice()
        );

        // Automatically update resource limit
        existingSubscription.setMaxResources(
                dto.getPlanName().getMaxResources()
        );

        Subscription updatedSubscription =
                subscriptionRepo.save(existingSubscription);

        return subscriptionMapper.toResponseDTO(
                updatedSubscription
        );
    }


    // DELETE SUBSCRIPTION
    public void deleteSubscription(Long id) {

        Subscription subscription =
                subscriptionRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Subscription not found with id: " + id
                        ));

        subscriptionRepo.delete(subscription);
    }
}