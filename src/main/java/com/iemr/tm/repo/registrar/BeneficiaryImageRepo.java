/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.tm.repo.registrar;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.tm.data.registrar.BeneficiaryImage;

@Repository

public interface BeneficiaryImageRepo extends CrudRepository<BeneficiaryImage, Long> {
	@Query(" SELECT benImage from BeneficiaryImage where beneficiaryRegID =:benRegID ")
	public String getBenImage(@Param("benRegID") Long benRegID);

	@Query(" SELECT beneficiaryRegID from BeneficiaryImage where beneficiaryRegID =:benRegID ")
	public Long findBenImage(@Param("benRegID") Long benRegID);

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryImage set benImage = :benImage, modifiedBy = :modifiedBy where beneficiaryRegID = :beneficiaryRegID ")
	public Integer updateBeneficiaryImage(@Param("benImage") String benImage, @Param("modifiedBy") String modifiedBy,
			@Param("beneficiaryRegID") Long beneficiaryRegID);

}
