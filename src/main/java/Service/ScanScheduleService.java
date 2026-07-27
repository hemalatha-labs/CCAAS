package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.ScanScheduleRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScanScheduleService {
	
	@Autowired
	private ScanScheduleRepo scanScheduleRepo;
	
	public List<ScanSchedule> getAllScanSchedules(){
		 return scanScheduleRepo.findAll();
	}
	
	public Optional<ScanSchedule> getScanSchedule(Long id) {
		return scanScheduleRepo.findById(id);
	}

	public ScanSchedule newScanSchedule(ScanSchedule scanSchedule) {
		return  scanScheduleRepo.save(scanSchedule);
	}
	
	public void deleteScanSchedule(Long id) {
		scanScheduleRepo.deleteById(id);
	}
}
