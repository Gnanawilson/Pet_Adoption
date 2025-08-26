import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getPets } from "../utils/api";
import "./PetListing.css";

function PetListing() {
  const [pets, setPets] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [speciesFilter, setSpeciesFilter] = useState("All");
  const [statusFilter, setStatusFilter] = useState("All");

  useEffect(() => {
    getPets()
      .then(setPets)
      .catch(() => setError("Failed to load pets"))
      .finally(() => setLoading(false));
  }, []);

  const filteredPets = pets.filter((pet) => {
    const speciesMatch = speciesFilter === "All" || pet.species === speciesFilter;
    const statusMatch = statusFilter === "All" || pet.adoptionStatus === statusFilter;
    return speciesMatch && statusMatch;
  });

return (
<div className="pet-listing">
<h2>Available Pets</h2>

<div className="filters">
<label htmlFor="species-filter">Filter by Species: </label>
<select
id="species-filter"
data-testid="species-filter"
value={speciesFilter}
onChange={(e) => setSpeciesFilter(e.target.value)}
>
<option value="All">All</option>
<option value="Dog">Dog</option>
<option value="Cat">Cat</option>
</select>

<label htmlFor="status-filter">Filter by Status: </label>
<select
id="status-filter"
data-testid="status-filter"
value={statusFilter}
onChange={(e) => setStatusFilter(e.target.value)}
>
<option value="All">All</option>
<option value="Available">Available</option>
<option value="Adopted">Adopted</option>
<option value="Pending">Pending</option>
</select>
</div>

{loading ? (
<p>Loading pets...</p>
) : error ? (
<p style={{ color: "red" }}>[Error - You need to specify the message]</p>
) : filteredPets.length > 0 ? (
<ul>
{filteredPets.map((pet) => (
<li key={pet.id} className="pet-card">
<img src={pet.imageUrl} alt={pet.name} />
<h3>{pet.name}</h3>
<p>
{pet.species} - {pet.breed}
</p>
<p>Status: {pet.adoptionStatus}</p>
<Link to={`/pets/${pet.id}`}>View Details</Link>
</li>
))}
</ul>
) : (
<p>No pets found matching the selected criteria.</p>
)}
</div>
);
}

export default PetListing;