import React from 'react';
import { Helmet } from 'react-helmet-async';
import { Container, Row, Col, Card } from 'react-bootstrap';
import { FaBullseye, FaEye, FaHandshake, FaGraduationCap, FaBuilding } from 'react-icons/fa';

const About = () => {
  const goals = [
    "Create 30,000+ skilled candidates",
    "Increase capacity of training programs",
    "Promote inclusive employment",
    "Improve individual employability"
  ];

  return (
    <>
      <Helmet>
        <title>About Us | Nirmal Bharat Skill Foundation Group</title>
      </Helmet>

      {/* Hero Banner */}
      <section className="page-hero bg-primary text-white py-5">
        <Container>
          <h1 className="display-4">About Us</h1>
          <p className="lead">Building Skilled India Since 2005</p>
        </Container>
      </section>

      {/* Who We Are */}
      <section className="py-5">
        <Container>
          <Row className="align-items-center">
            <Col lg={6}>
              <h2 className="mb-4">Who We Are</h2>
              <p>
                Nirmal Bharat Skill Development Center is a skill and talent development corporation
                that aims to build a skilled manpower pool to meet industry needs. We work with the
                Maharashtra State Skill Development Society (MSSDS) through a public–private partnership.
              </p>
              <p>
                Our organization focuses on transforming learning, building leaders, and bridging
                skill gaps between education and industry, with emphasis on employability and impactful education.
              </p>
            </Col>
            <Col lg={6}>
              <img
                src="/images/about-team.jpg"
                alt="NBSF Team"
                className="img-fluid rounded"
              />
            </Col>
          </Row>
        </Container>
      </section>

      {/* Mission & Vision */}
      <section className="py-5 bg-light">
        <Container>
          <Row className="g-4">
            <Col md={6}>
              <Card className="h-100 border-0 shadow">
                <Card.Body className="text-center p-4">
                  <FaBullseye className="text-primary mb-3" size={50} />
                  <h3>Our Mission</h3>
                  <p>
                    To transform learning, build leaders, and bridge skill gaps between
                    education and industry through employability-focused education.
                  </p>
                </Card.Body>
              </Card>
            </Col>
            <Col md={6}>
              <Card className="h-100 border-0 shadow">
                <Card.Body className="text-center p-4">
                  <FaEye className="text-primary mb-3" size={50} />
                  <h3>Our Vision</h3>
                  <p>
                    To be Maharashtra's leading skill development partner, creating a
                    skilled workforce that drives economic growth and social development.
                  </p>
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      </section>

      {/* Our Purpose */}
      <section className="py-5">
        <Container>
          <h2 className="text-center mb-5">Our Purpose</h2>
          <Row className="g-4">
            <Col md={4}>
              <div className="text-center p-4">
                <FaHandshake className="text-warning mb-3" size={40} />
                <h4>Bridge Industry Gap</h4>
                <p>Connect job market demand with skilled youth</p>
              </div>
            </Col>
            <Col md={4}>
              <div className="text-center p-4">
                <FaGraduationCap className="text-warning mb-3" size={40} />
                <h4>Employment-Oriented Education</h4>
                <p>Offer practical, job-focused training programs</p>
              </div>
            </Col>
            <Col md={4}>
              <div className="text-center p-4">
                <FaBuilding className="text-warning mb-3" size={40} />
                <h4>Pan-Maharashtra Presence</h4>
                <p>Multiple learning centers across rural and urban locations</p>
              </div>
            </Col>
          </Row>
        </Container>
      </section>

      {/* Our Goals */}
      <section className="py-5 bg-primary text-white">
        <Container>
          <h2 className="text-center mb-5">Our Goals</h2>
          <Row className="g-3">
            {goals.map((goal, index) => (
              <Col md={6} key={index}>
                <div className="d-flex align-items-center">
                  <FaBullseye className="me-3" />
                  <span>{goal}</span>
                </div>
              </Col>
            ))}
          </Row>
        </Container>
      </section>

      {/* Founder Message */}
      <section className="py-5">
        <Container>
          <Row className="align-items-center">
            <Col md={4} className="text-center">
              <img
                src="/images/founder.jpg"
                alt="Shri Abhaysinh B Deshmukh"
                className="img-fluid rounded-circle mb-3"
                style={{ width: '200px', height: '200px', objectFit: 'cover' }}
              />
              <h4>Shri Abhaysinh B Deshmukh</h4>
              <p className="text-muted">Founder & Director</p>
            </Col>
            <Col md={8}>
              <h3 className="mb-4">Founder's Message</h3>
              <blockquote className="blockquote fs-5">
                "Education is not just about acquiring knowledge, but about transforming lives.
                At Nirmal Bharat Skill Foundation, we believe in empowering youth with skills
                that make them industry-ready and life-ready. Our mission is to bridge the gap
                between education and employment, creating opportunities for thousands of young
                Indians."
              </blockquote>
            </Col>
          </Row>
        </Container>
      </section>

      {/* 30,000+ Vision */}
      <section className="py-5 bg-warning text-dark text-center">
        <Container>
          <h2 className="display-3 mb-3">30,000+</h2>
          <h3>Target Beneficiaries by 2025</h3>
          <p className="lead mt-3">
            Our commitment to skill development and employment generation across Maharashtra
          </p>
        </Container>
      </section>

      {/* Social Impact */}
      <section className="py-5">
        <Container>
          <h2 className="text-center mb-5">Social Impact</h2>
          <Row className="g-4">
            <Col md={4}>
              <div className="text-center p-4">
                <div className="impact-number text-primary">60%</div>
                <h4>Rural Reach</h4>
                <p>Training programs in rural areas</p>
              </div>
            </Col>
            <Col md={4}>
              <div className="text-center p-4">
                <div className="impact-number text-primary">45%</div>
                <h4>Women Participation</h4>
                <p>Female trainees in our programs</p>
              </div>
            </Col>
            <Col md={4}>
              <div className="text-center p-4">
                <div className="impact-number text-primary">87%</div>
                <h4>Placement Rate</h4>
                <p>Successful job placements</p>
              </div>
            </Col>
          </Row>
        </Container>
      </section>
    </>
  );
};

export default About;