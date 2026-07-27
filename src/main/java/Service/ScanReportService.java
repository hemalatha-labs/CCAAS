package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.ScanReportRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScanReportService {
	
	@Autowired
	private ScanReportRepo scanReportRepo;
	
	public List<ScanReport> getAllScanReports(){
		 return scanReportRepo.findAll();
	}
	
	public Optional<ScanReport> getScanReport(Long id) {
		return scanReportRepo.findById(id);
	}

	public ScanReport newScanReport(ScanReport scanReport) {
		return  scanReportRepo.save(scanReport);
	}
	
	public void deleteScanReport(Long id) {
		scanReportRepo.deleteById(id);
	}
}
