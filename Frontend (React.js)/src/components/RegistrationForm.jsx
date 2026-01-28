import React, { useState } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import { Container, Row, Col, Button, Alert, Spinner } from 'react-bootstrap';
import axios from 'axios';

const RegistrationForm = () => {
  const [submitting, setSubmitting] = useState(false);
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState('');

  const validationSchema = Yup.object({
    fullName: Yup.string().required('Full name is required'),
    email: Yup.string().email('Invalid email').required('Email is required'),
    phone: Yup.string()
      .matches(/^[0-9]{10}$/, 'Phone number must be 10 digits')
      .required('Phone number is required'),
    dateOfBirth: Yup.date().required('Date of birth is required'),
    education: Yup.string().required('Education is required'),
    courseId: Yup.string().required('Please select a course'),
    address: Yup.string().required('Address is required'),
    city: Yup.string().required('City is required'),
    state: Yup.string().required('State is required'),
    pincode: Yup.string().required('Pincode is required'),
  });

  const initialValues = {
    fullName: '',
    email: '',
    phone: '',
    dateOfBirth: '',
    education: '',
    courseId: '',
    address: '',
    city: '',
    state: '',
    pincode: '',
    resume: null
  };

  const handleSubmit = async (values, { resetForm }) => {
    setSubmitting(true);
    setError('');
    
    try {
      const formData = new FormData();
      Object.keys(values).forEach(key => {
        if (key !== 'resume' || values[key]) {
          formData.append(key, values[key]);
        }
      });

      const response = await axios.post('/api/students/register', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      });

      if (response.data.success) {
        setSuccess(true);
        resetForm();
        
        // Send WhatsApp message
        const whatsappMessage = `New Registration:%0A%0AName: ${values.fullName}%0APhone: ${values.phone}%0AEmail: ${values.email}%0ACourse: ${values.courseId}`;
        window.open(`https://wa.me/919860085999?text=${whatsappMessage}`, '_blank');
      }
    } catch (err) {
      setError(err.response?.data?.message || 'Registration failed. Please try again.');
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <Container className="py-5">
      <Row className="justify-content-center">
        <Col lg={8}>
          <div className="registration-form p-4 shadow rounded">
            <h2 className="text-center mb-4">Register for Skill Training</h2>
            
            {success && (
              <Alert variant="success" onClose={() => setSuccess(false)} dismissible>
                Registration successful! Our team will contact you shortly.
              </Alert>
            )}
            
            {error && (
              <Alert variant="danger" onClose={() => setError('')} dismissible>
                {error}
              </Alert>
            )}
            
            <Formik
              initialValues={initialValues}
              validationSchema={validationSchema}
              onSubmit={handleSubmit}
            >
              {({ setFieldValue }) => (
                <Form>
                  <Row>
                    <Col md={6}>
                      <div className="mb-3">
                        <label htmlFor="fullName" className="form-label">Full Name *</label>
                        <Field
                          type="text"
                          name="fullName"
                          className="form-control"
                          placeholder="Enter your full name"
                        />
                        <ErrorMessage name="fullName" component="div" className="text-danger small" />
                      </div>
                    </Col>
                    
                    <Col md={6}>
                      <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email *</label>
                        <Field
                          type="email"
                          name="email"
                          className="form-control"
                          placeholder="Enter your email"
                        />
                        <ErrorMessage name="email" component="div" className="text-danger small" />
                      </div>
                    </Col>
                  </Row>
                  
                  <Row>
                    <Col md={6}>
                      <div className="mb-3">
                        <label htmlFor="phone" className="form-label">Phone Number *</label>
                        <Field
                          type="tel"
                          name="phone"
                          className="form-control"
                          placeholder="Enter 10-digit phone number"
                        />
                        <ErrorMessage name="phone" component="div" className="text-danger small" />
                      </div>
                    </Col>
                    
                    <Col md={6}>
                      <div className="mb-3">
                        <label htmlFor="dateOfBirth" className="form-label">Date of Birth *</label>
                        <Field
                          type="date"
                          name="dateOfBirth"
                          className="form-control"
                        />
                        <ErrorMessage name="dateOfBirth" component="div" className="text-danger small" />
                      </div>
                    </Col>
                  </Row>
                  
                  <Row>
                    <Col md={6}>
                      <div className="mb-3">
                        <label htmlFor="education" className="form-label">Highest Education *</label>
                        <Field as="select" name="education" className="form-select">
                          <option value="">Select Education</option>
                          <option value="10th Pass">10th Pass</option>
                          <option value="12th Pass">12th Pass</option>
                          <option value="Graduate">Graduate</option>
                          <option value="Post Graduate">Post Graduate</option>
                          <option value="Diploma">Diploma</option>
                        </Field>
                        <ErrorMessage name="education" component="div" className="text-danger small" />
                      </div>
                    </Col>
                    
                    <Col md={6}>
                      <div className="mb-3">
                        <label htmlFor="courseId" className="form-label">Select Course *</label>
                        <Field as="select" name="courseId" className="form-select">
                          <option value="">Select Course</option>
                          <option value="1">Digital Marketing Executive</option>
                          <option value="2">Healthcare Assistant</option>
                          <option value="3">Retail Sales Associate</option>
                          <option value="4">Data Entry Operator</option>
                          <option value="5">Electrician (ITI)</option>
                          <option value="6">Hotel Management Trainee</option>
                        </Field>
                        <ErrorMessage name="courseId" component="div" className="text-danger small" />
                      </div>
                    </Col>
                  </Row>
                  
                  <div className="mb-3">
                    <label htmlFor="address" className="form-label">Address *</label>
                    <Field
                      as="textarea"
                      name="address"
                      className="form-control"
                      rows="3"
                      placeholder="Enter your complete address"
                    />
                    <ErrorMessage name="address" component="div" className="text-danger small" />
                  </div>
                  
                  <Row>
                    <Col md={4}>
                      <div className="mb-3">
                        <label htmlFor="city" className="form-label">City *</label>
                        <Field
                          type="text"
                          name="city"
                          className="form-control"
                          placeholder="City"
                        />
                        <ErrorMessage name="city" component="div" className="text-danger small" />
                      </div>
                    </Col>
                    
                    <Col md={4}>
                      <div className="mb-3">
                        <label htmlFor="state" className="form-label">State *</label>
                        <Field as="select" name="state" className="form-select">
                          <option value="">Select State</option>
                          <option value="Maharashtra">Maharashtra</option>
                          <option value="Other">Other</option>
                        </Field>
                        <ErrorMessage name="state" component="div" className="text-danger small" />
                      </div>
                    </Col>
                    
                    <Col md={4}>
                      <div className="mb-3">
                        <label htmlFor="pincode" className="form-label">Pincode *</label>
                        <Field
                          type="text"
                          name="pincode"
                          className="form-control"
                          placeholder="Pincode"
                        />
                        <ErrorMessage name="pincode" component="div" className="text-danger small" />
                      </div>
                    </Col>
                  </Row>
                  
                  <div className="mb-4">
                    <label htmlFor="resume" className="form-label">Upload Resume (Optional)</label>
                    <input
                      type="file"
                      name="resume"
                      className="form-control"
                      accept=".pdf,.doc,.docx"
                      onChange={(event) => {
                        setFieldValue("resume", event.currentTarget.files[0]);
                      }}
                    />
                  </div>
                  
                  <div className="text-center">
                    <Button
                      type="submit"
                      variant="warning"
                      size="lg"
                      disabled={submitting}
                      className="px-5"
                    >
                      {submitting ? (
                        <>
                          <Spinner animation="border" size="sm" className="me-2" />
                          Submitting...
                        </>
                      ) : (
                        'Submit Registration'
                      )}
                    </Button>
                  </div>
                  
                  <p className="text-muted small mt-3">
                    * Required fields. By submitting this form, you agree to our terms and conditions.
                  </p>
                </Form>
              )}
            </Formik>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default RegistrationForm;