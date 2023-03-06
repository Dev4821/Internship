import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VendorServiceTest {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorServiceImpl vendorService;

    @Test
    public void testGetVendorById() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(1L);
        vendor.setVendorName("ABC Corporation");
        vendor.setVendorCode("ABC");
        vendor.setAddress("123 Main Street");
        vendor.setCity("Anytown");
        vendor.setState("CA");
        vendor.setPincode("123456");
        vendor.setPhone("555-1234");
        vendor.setEmail("abc@example.com");

        when(vendorRepository.findById(1L)).thenReturn(Optional.of(vendor));

        Vendor result = vendorService.getVendorById(1L);

        assertEquals(vendor, result);
    }
     @Test(expected = DuplicateKeyException.class)
    public void testCreateVendorWithExistingCode() {
    Vendor vendor = new Vendor("Test Vendor", "TEST001", "123 Main St", "Anytown", "CA", "123456", "1234567890", "test@test.com");
    when(vendorRepository.findByVendorCode(vendor.getVendorCode())).thenReturn(Optional.of(new Vendor()));
    vendorService.createVendor(vendor);
}
   @Test(expected = ResourceNotFoundException.class)
    public void testUpdateNonExistingVendor() {
    Vendor vendor = new Vendor("Test Vendor", "TEST001", "123 Main St", "Anytown", "CA", "123456", "1234567890", "test@test.com");
    when(vendorRepository.findById(anyLong())).thenReturn(Optional.empty());
    vendorService.updateVendor(1L, vendor);
}

    
}

