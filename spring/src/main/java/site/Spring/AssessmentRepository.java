package site.Spring;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface AssessmentRepository extends JpaRepository<Exam, Long> {
}
