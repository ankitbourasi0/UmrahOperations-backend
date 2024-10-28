package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.ExtraVisaPriceDTO;
import com.umrahoperations.UmrahOperations.dto.UserDTO;

import com.umrahoperations.UmrahOperations.repository.ExtraVisaPriceRepository;
import com.umrahoperations.UmrahOperations.utils.CurrentUserUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraVisaService {

    @Autowired
    private ExtraVisaPriceRepository   extraVisaPriceRepository;

    @Autowired
    private CountryCodeService countryCodeService;

    @Autowired
    private CurrentUserUtil currentUserUtil;

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(ExtraVisaService.class);

    public List<ExtraVisaPriceDTO> getExtraVisaPrice() {

        Integer  sourceID = countryCodeService.getCountryCode();
        Integer userCountryCode = currentUserUtil.getCurrentUserCountryCode(request);

        if (sourceID != null && userCountryCode != null) {
            logger.info("Source ID: {}", sourceID);
            logger.info("User Country Code: {}", userCountryCode);

            List<ExtraVisaPriceDTO> extravisaprice = extraVisaPriceRepository.getExtraVisaPrices(userCountryCode, sourceID);
            logger.info("ExtraPrice: {}", extravisaprice);

            extravisaprice.forEach(System.out::println);

            return extravisaprice;
        }

        return null;

    }
}
