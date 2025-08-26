
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getPetById, submitAdoptionRequest } from "../utils/api";
import "./PetDetails.css";

function PetDetails() {
  const { id } = useParams();
  const [pet, setPet] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [form, setForm] = useState({
    applicantName: "",
    applicantEmail: "",
    applicantPhone: "",
  });
  const [message, setMessage] = useState("");

  useEffect(() => {
    getPetById(id)
      .then(setPet)
      .catch(() => setError("Could not fetch pet details"))
      .finally(() => setLoading(false));
  }, [id]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const req = { ...form, petId: parseInt(id) };
      const response = await submitAdoptionRequest(req);
      setMessage(`Adoption request submitted! Status: ${response.status}`);
    } catch (err) {
      setMessage(err.message);
    }
  };

  if (loading) return <p>Loading pet details...</p>;
  if (error) return <p style={{ color: "red" }}>{error}</p>;
  if (!pet) return <p>Pet not found</p>;

 return (
    <div className="pet-details">
      <h2>{pet.name}</h2>
      {pet.imageUrl && <img src={pet.imageUrl} alt={pet.name} />}
      {pet.species && <p>Species: {pet.species}</p>}
      {pet.breed && <p>Breed: {pet.breed}</p>}
      {pet.age !== undefined && <p>Age: {pet.age} months</p>}
      {pet.description && <p>{pet.description}</p>}
      {pet.adoptionStatus && <p>Status: {pet.adoptionStatus}</p>}

   {pet.adoptionStatus === "Available" && (
<form onSubmit={handleSubmit} className="adoption-form">
<h3>Adopt {pet.name}</h3>
<input
type="text"
name="applicantName"
placeholder="Your Name"
value={form.applicantName}
onChange={handleChange}
required
/>
<input
type="email"
name="applicantEmail"
placeholder="Your Email"
value={form.applicantEmail}
onChange={handleChange}
required
/>
<input
type="text"
name="applicantPhone"
placeholder="Your Phone"
value={form.applicantPhone}
onChange={handleChange}
required
/>
<button type="submit">Submit Request</button>
</form>
)}

{message && <p style={{ color: "green" }}>{message}</p>}
</div>
);
}

export default PetDetails;
