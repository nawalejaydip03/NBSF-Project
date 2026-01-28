import axios from 'axios';

// Base API configuration
const API_BASE_URL = process.env.REACT_APP_API_URL || '';

// Create axios instance
const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// Student API endpoints
export const studentAPI = {
    register: (formData) => {
        return api.post('/api/students/register', formData, {
            headers: {
                'Content-Type': 'multipart/form-data',
            },
        });
    },
    getAll: () => api.get('/api/students'),
    getById: (id) => api.get(`/api/students/${id}`),
    getStats: () => api.get('/api/students/stats'),
};

// Course API endpoints
export const courseAPI = {
    getAll: () => api.get('/api/courses'),
    getById: (id) => api.get(`/api/courses/${id}`),
    create: (courseData) => api.post('/api/courses', courseData),
    update: (id, courseData) => api.put(`/api/courses/${id}`, courseData),
    delete: (id) => api.delete(`/api/courses/${id}`),
};

// Contact/Enquiry API endpoints
export const enquiryAPI = {
    submit: (enquiryData) => api.post('/api/enquiries', enquiryData),
    getAll: () => api.get('/api/enquiries'),
    getById: (id) => api.get(`/api/enquiries/${id}`),
};

// Contact API endpoints
export const contactAPI = {
    submit: (contactData) => api.post('/api/contact', contactData),
    getAll: () => api.get('/api/contact'),
};

export default api;
