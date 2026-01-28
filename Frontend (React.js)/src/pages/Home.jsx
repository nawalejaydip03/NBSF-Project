import React from 'react';
import { Helmet } from 'react-helmet-async';
import { Container, Row, Col, Button } from 'react-bootstrap';
import { FaGraduationCap, FaBriefcase, FaUsers, FaBuilding, FaChartLine } from 'react-icons/fa';
// import StatCounter from '../components/StatCounter';
// import ServiceCard from '../components/ServiceCard';
// import TestimonialSlider from '../components/TestimonialSlider';

const Home = () => {
  /*
  const services = [
    {
      icon: <FaGraduationCap />,
      title: "Skill Training",
      description: "Industry-relevant courses with government certification"
    },
    {
      icon: <FaBriefcase />,
      title: "Placement Assistance",
      description: "100% placement support with 500+ companies network"
    },
    {
      icon: <FaChartLine />,
      title: "Career Guidance",
      description: "Professional counseling and aptitude testing"
    },
    {
      icon: <FaUsers />,
      title: "HR & Recruitment Solutions",
      description: "Comprehensive staffing solutions for businesses"
    },
    {
      icon: <FaBuilding />,
      title: "Rural & Urban Skill Centers",
      description: "Accessible training across Maharashtra"
    }
  ];
  */

  return (
    <>
      <Helmet>
        <title>Nirmal Bharat Skill Foundation Group | Empowering Youth. Building Skilled India.</title>
        <meta name="description" content="MSSDS affiliated skill development foundation providing government-certified training and placement assistance across Maharashtra" />
      </Helmet>

      {/* Hero Section */}
      <section className="hero-section">
        <Container>
          <Row className="align-items-center min-vh-80">
            <Col lg={8}>
              <h1 className="hero-title">Empowering Youth Through Skill Development & Employment</h1>
              <p className="hero-subtitle">
                A Maharashtra State Skill Development Society (MSSDS) affiliated foundation working to bridge the gap between education and industry.
              </p>
              <div className="hero-buttons mt-4">
                <Button href="/courses" variant="warning" className="me-3">Explore Courses</Button>
                <Button href="/contact" variant="outline-light" className="me-3">Apply for Training</Button>
                <Button href="/partners" variant="outline-light">Become a Partner</Button>
              </div>
            </Col>
          </Row>
        </Container>
      </section>

      {/* Stats Section Placeholder */}
      <section className="stats-section py-5 bg-light">
        <Container><h2 className="text-center">Our Stats</h2><p className="text-center">20+ Years Experience | 20,000+ Students Trained</p></Container>
      </section>

      {/* Services Section Placeholder */}
      <section className="services-section py-5">
        <Container><h2 className="text-center">Our Services</h2><p className="text-center">Skill Training, Placement Assistance, Career Guidance, and more.</p></Container>
      </section>


      {/* Government Partnership */}
      <section className="gov-section py-5 bg-primary text-white">
        <Container>
          <Row className="align-items-center">
            <Col md={6}>
              <div className="gov-logo-card p-4 bg-white rounded">
                <h3 className="text-primary text-center mb-4">MAHARASHTRA STATE SKILL DEVELOPMENT SOCIETY</h3>
                <p className="text-center text-dark">Public-Private Partnership</p>
              </div>
            </Col>
            <Col md={6}>
              <h3 className="mb-4">Government Partnership</h3>
              <p>Nirmal Bharat Skill Foundation Group operates under the Public-Private Partnership (PPP) model with MSSDS.</p>
              <ul className="mt-3">
                <li>Government-recognized certification</li>
                <li>Subsidized training programs</li>
                <li>Industry-aligned curriculum</li>
                <li>Quality assurance as per NSQF guidelines</li>
              </ul>
            </Col>
          </Row>
        </Container>
      </section>

      {/* Testimonials Placeholder */}
      <section className="testimonial-section py-5 bg-light">
        <Container><h2 className="text-center">Success Stories</h2><p className="text-center">Coming soon...</p></Container>
      </section>

      {/* CTA Section */}
      <section className="cta-section py-5 bg-warning text-dark">
        <Container className="text-center">
          <h2 className="mb-3">Ready to Start Your Career Journey?</h2>
          <p className="lead mb-4">Join thousands of successful students who transformed their lives</p>
          <Button href="/contact" variant="dark" size="lg">Register Now for Skill Training</Button>
        </Container>
      </section>
    </>
  );
};

export default Home;