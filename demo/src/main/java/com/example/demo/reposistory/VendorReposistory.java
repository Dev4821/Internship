import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    
    Vendor findByVendorName(String vendorName);
    
    Vendor findByVendorCode(String vendorCode);
}
