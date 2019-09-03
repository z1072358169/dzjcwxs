package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.EvidenceTypeMapper;
import zygh.yfb.wxy.service.EvidenceTypeService;
import zygh.yfb.wxy.vo.EvidenceType;

public class EvidenceTypeServiceimpl implements EvidenceTypeService {
	
	@Autowired
	private EvidenceTypeMapper evidenceTypeMapper;

	public List<EvidenceType> findEvidenceType(EvidenceType evidenceType)
			throws Exception {
		// TODO Auto-generated method stub
		return evidenceTypeMapper.findEvidenceType(evidenceType);
	}

	public void addEvidenceType(EvidenceType evidenceType) throws Exception {
		// TODO Auto-generated method stub
		evidenceTypeMapper.addEvidenceType(evidenceType);
	}

	public void deleteEvidenceType(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		evidenceTypeMapper.deleteEvidenceType(sysIds);
	}

	public void updateEvidenceType(EvidenceType evidenceType) throws Exception {
		// TODO Auto-generated method stub
		evidenceTypeMapper.updateEvidenceType(evidenceType);
	}

}
