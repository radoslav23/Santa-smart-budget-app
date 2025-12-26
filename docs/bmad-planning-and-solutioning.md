# BMAD Phase 2: Planning

## Goals
- Implement core transaction features (add, view, filter)
- Structure code using MVC pattern
- Enable REST API testing via IntelliJ HTTP client

## Planned Features
- Add income/expense transactions
- View all transactions
- Filter by type (income/expense)
- Summary endpoint (income, expense, balance)

## Tools
- IntelliJ IDEA
- Java 17
- Spring Boot 3.x
- H2 Database
- Spring Web, Spring Data JPA
- IntelliJ HTTP Client

---

# BMAD Phase 3: Solutioning

## Architecture
- Layered MVC structure:
    - `model`: domain entity `Transaction`
    - `repository`: Spring Data JPA interface
    - `service`: business logic
    - `controller`: REST endpoints

## API Endpoints
- `POST /api/transactions` — add transaction
- `GET /api/transactions` — get all
- `GET /api/transactions/type/{type}` — filter by type
- `GET /api/transactions/summary` — get totals

## Git Strategy
- Commits per BMAD phase
- Clear messages: `BMAD Phase 2 – Planning`, `BMAD Phase 3 – Solutioning`

## Testing
- `.http` file for API calls
- Verified 200 OK responses for all endpoints