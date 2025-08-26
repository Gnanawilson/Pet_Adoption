import { BASE_URL } from "./constants";

export async function getPets() {
  const res = await fetch(`${BASE_URL}/pets`);
  if (!res.ok) throw new Error("Failed to fetch pets");
  return res.json();
}

export async function getPetById(id) {
  const res = await fetch(`${BASE_URL}/pets/${id}`);
  if (!res.ok) throw new Error("Pet not found");
  return res.json();
}

export async function submitAdoptionRequest(data) {
  const res = await fetch(`${BASE_URL}/adoption-requests`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });

  if (!res.ok) {
    const err = await res.json();
    throw new Error(err.message || "Adoption request failed");
  }
  return res.json();
}

